(ns game-of-life-clojure.core
  (:gen-class)
  (:use game-of-life-clojure.display))

(defn -main [& args]
  (let [size 4
        values (repeatedly #(rand-nth [true false]))
        data (take size (repeatedly #(take size values)))]
    ;(println (take 8 values))
    (println data)
    ;(show-window data 5)
    ))
