(ns book-living-clojure.ch3.swap)

(def who-atom (atom :caterpillar))

(println @who-atom)

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(swap! who-atom change)
(println @who-atom)

(swap! who-atom change)
(println @who-atom)

(swap! who-atom change)
(println @who-atom)

(println "===========================")

(def counter (atom 0))

(println @counter)

(dotimes [_ 5] (swap! counter inc))

(println @counter)

(println "===========================")

(def counter (atom 0))
(println @counter)
(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))

(println @counter)
(println "===========================")

(def counter (atom 0))
(println @counter)

(defn inc-print [val]
  (println val)
  (inc val))

(swap! counter inc-print)
(println @counter)
(println "===========================")

(def counter (atom 0))
(println @counter)

(let [n 2]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))

(println  (str "real is " @counter))
