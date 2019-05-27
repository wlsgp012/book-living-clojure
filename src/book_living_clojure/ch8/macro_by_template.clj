(ns book-living-clojure.ch8.macro-by-template)

(println (let [x 5] `(first [x 2 3])))
(println (let [x 5] `(first [~x 2 3])))

(defn hi-queen [phrase]
  (str phrase ", so please your Majesty."))

(defmacro def-hi-queen [name phrase]
  `(defn ~(symbol name) []
     (hi-queen ~phrase)))

(def-hi-queen dormouse-hi-queen "I am the Dormouse")

(println (dormouse-hi-queen))