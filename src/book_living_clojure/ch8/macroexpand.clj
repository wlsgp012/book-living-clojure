(ns book-living-clojure.ch8.macroexpand)

(println (macroexpand-1
           '(when (= 2 2) (println "It is four!!!"))))
