(ns book-living-clojure.ch3.stm)

(def alice-height (ref 3))
(def right-hand-bites (ref 10))
(println @alice-height)
(println @right-hand-bites)

(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))

;(eat-from-right-hand)

(dosync (eat-from-right-hand))

(println @alice-height)
(println @right-hand-bites)