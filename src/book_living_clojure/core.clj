(ns book-living-clojure.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn border []
  (println)
  (println "-----------------------------------------")
  (println))

(defn titleBorder [title]
  (println)
  (println (str "----------------------- " title " ------------------"))
  (println))

(defn -main [& args]
  (println (first args)))