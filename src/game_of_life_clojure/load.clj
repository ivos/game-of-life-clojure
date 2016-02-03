(ns game-of-life-clojure.load)

(defn load-random [size]
  (let [random-boolean-list (fn [] (repeatedly size #(rand-nth [true false])))
        data (repeatedly size random-boolean-list)]
    data))
