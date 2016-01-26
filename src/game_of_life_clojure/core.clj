(ns game-of-life-clojure.core
  (:gen-class)
  (:use game-of-life-clojure.display))

(defn -main [& args]
  (show-window 100 5))
