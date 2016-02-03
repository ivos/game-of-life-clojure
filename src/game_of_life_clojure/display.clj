(ns game-of-life-clojure.display
  (:use seesaw.core)
  (:use seesaw.graphics))

(def game-of-life-window
  (frame :title "Game of Life"
         :minimum-size [800 :by 640]
         :on-close :exit))

(defn show-window []
  (native!)
  (-> game-of-life-window pack! show!))

(def cell-size 5)

(defn draw-cell [canvas graphics x y value]
  (let [cell-width (- cell-size 1)
        color (if value "#000000" "#ffffff")]
    (draw graphics
          (rect (* x cell-size) (* y cell-size) cell-width cell-width)
          (style :foreground color :background color))))

(defn paint-fn [canvas graphics data]
  (println "paint")
  (doseq [x (range (count data))
          y (range (count (nth data 0)))]
    (draw-cell canvas graphics x y (nth (nth data x) y))))

(defn window-content [data]
  (let [content-canvas (canvas :id :canvas :background "#ffffff" :paint #(paint-fn %1 %2 data))]
    (border-panel :center content-canvas)))

(defn display! [data]
  (config! game-of-life-window :content (window-content data)))
