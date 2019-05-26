(ns book-living-clojure.ch6.async-alts
  (:require [clojure.core.async :refer [>! <! >!! <!! chan close! go go-loop alts!]]))

(def tea-channel (chan 10))
(def milk-channel (chan 10))
(def sugar-channel (chan 10))

(go-loop []
  (let [[v ch] (alts! [tea-channel milk-channel sugar-channel])]
    (println "Got" v "from" ch)
    (recur)))

(>!! sugar-channel :sugar)
(>!! milk-channel :milk)
(>!! tea-channel :tea)

(Thread/sleep 5)