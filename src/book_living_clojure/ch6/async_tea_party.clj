(ns book-living-clojure.ch6.async-tea-party
  (:gen-class)
  (:require [clojure.core.async :refer [>! <! <!! chan go alts!]]))

(def google-tea-service-chan (chan 10))
(def yahoo-tea-service-chan (chan 10))
(def result-chan (chan 10))

(defn random-add []
  (reduce + (repeat (rand-int 1000) 1)))

(defn request-google-tea-service []
  (go
    (random-add)
    (>! google-tea-service-chan "tea compliments of google")))

(defn request-yahoo-tea-service []
  (go
    (random-add)
    (>! yahoo-tea-service-chan "tea compliments of yahoo")))

(defn request-tea []
  (request-google-tea-service)
  (request-yahoo-tea-service)
  (go (let [[v] (alts! [google-tea-service-chan yahoo-tea-service-chan])]
        (>! result-chan v))))
;
;(request-tea)
;(Thread/sleep 3000)

(defn -main [& args]
  (println "Requesting tea!")
  (request-tea)
  (println (<!! result-chan)))