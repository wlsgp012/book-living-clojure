(ns book-living-clojure.ch3.stm2)

(def alice-height (ref 3))
(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (dosync (when (pos? @right-hand-bites)
            (alter right-hand-bites dec)
            (alter alice-height #(+ % 24)))))

(let [n 2]
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand)))
  (future (dotimes [_ n] (eat-from-right-hand))))

(println @alice-height)
(println @right-hand-bites)