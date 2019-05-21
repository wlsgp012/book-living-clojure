(ns book-living-clojure.ch3.ref-set)

(def x (ref 1))
(def y (ref 1))

(defn new-values []
  (dosync
    (alter x inc)
    (ref-set y (+ 2 @x))))

(let [n 2]
  (future (dotimes [_ n] (new-values)))
  (future (dotimes [_ n] (new-values))))

(println @x)
(println @y)