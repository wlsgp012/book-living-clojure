(ns book-living-clojure.ch2.ch2)

(println
  (for [animal [:mouse :duck :lory]
        color [:red :blue]
        :let [animal-str (str "anmial-" (name animal))
              color-str (str "color-" (name color))
              display-str (str animal-str "-" color-str)]
        :when (= color :blue)]
    display-str))


(println (flatten [[:duck [:mouse] [[:lory]]]]))

(println (vec '(1 2 3)))

(println (into [1] '[1 2 3]))

(println (sorted-map :b 2 :a 1 :z 3))

(println (into (sorted-map) {:b 2 :a 1 :z 3}))

(println (into {} [[:a 1] [:b 2] [:c 3]]))

(println (into [] {:a 1 :b 2 :c 3}))

(println (partition 3 (vec (range 10))))

(println (partition-all 3 (vec (range 10))))

(println (partition-by #(= 6 %) (vec (range 10))))

