(ns book-living-clojure.ch3.ch3)

(def who-atom (atom :caterpillar))

(println who-atom)
(println @who-atom)

(reset! who-atom :chrysalis)

(println who-atom)
(println @who-atom)