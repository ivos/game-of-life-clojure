(ns game-of-life-clojure.display
  (:use seesaw.core)
  (:use seesaw.graphics))

(defn paint-fn [canvas graphics]
  (doto graphics
    (draw
      (rect 10 10 5 5)
      (style :foreground "#000000" :background "#000000"))))

(def window-content
  (border-panel :hgap 5 :vgap 5 :border 5
                :center (canvas :id :canvas :background "#FFFFFF" :paint paint-fn)))

(defn show-window [size cell-size]
  (def window-size (* size cell-size))
  (native!)
  (invoke-later
    (-> (frame :title "Game of Life"
               :minimum-size [window-size :by window-size]
               :content window-content
               :on-close :exit)
        pack! show!)))
