(ns game-of-life-clojure.core
  (:gen-class)
  (:use game-of-life-clojure.load)
  (:use game-of-life-clojure.display)
  (:use game-of-life-clojure.logic))

(defn -main [& args]
  (let [seed-data (load-random 10)]
    (show-window)
    (run seed-data)))
