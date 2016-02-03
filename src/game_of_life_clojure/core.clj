(ns game-of-life-clojure.core
  (:gen-class)
  (:use game-of-life-clojure.load)
  (:use game-of-life-clojure.display))

(defn -main [& args]
  (let [data (load-random 100)]
    (show-window data 5)))
