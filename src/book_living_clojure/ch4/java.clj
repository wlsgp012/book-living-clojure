(ns book-living-clojure.ch4.java)

(println (class "caterpillar"))

(println (. "caterpillar" toUpperCase))
(println (.toUpperCase "caterpillar"))