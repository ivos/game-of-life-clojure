(ns game-of-life-clojure.display
  (:use seesaw.core)
  (:use seesaw.graphics))

(defn draw-cell [canvas graphics x y cell-size value]
  (let [cell-width (- cell-size 1)
        color (if value "#000000" "#ffffff")]
    (draw graphics
          (rect (* x cell-size) (* y cell-size) cell-width cell-width)
          (style :foreground color :background color))))

(defn paint-fn [canvas graphics data cell-size]
  (doseq [x (range (count data))
          y (range (count (nth data 0)))]
    (draw-cell canvas graphics x y cell-size (nth (nth data x) y))))

(defn window-content [data cell-size]
  (let [content-canvas (canvas :id :canvas :background "#ffffff" :paint #(paint-fn %1 %2 data cell-size))]
    (border-panel :center content-canvas)))

(defn show-window [data cell-size]
  (let [x-size (max 800 (* (count data) cell-size))
        y-size (max 640 (* (count (nth data 0)) cell-size))]
    (native!)
    (invoke-later
      (-> (frame :title "Game of Life"
                 :minimum-size [x-size :by y-size]
                 :content (window-content data cell-size)
                 :on-close :exit)
          pack! show!))))
