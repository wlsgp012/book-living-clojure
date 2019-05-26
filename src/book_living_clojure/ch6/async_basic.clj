(ns book-living-clojure.ch6.async-basic
  (:require [clojure.core.async :refer [>! <! >!! <!! chan close! go go-loop alts!]]
            [book-living-clojure.core :as jin]))
(println "init")
(def tea-channel (chan 10))
(println "before inset")
;(println (>!! tea-channel nil)) error!!!
(println (>!! tea-channel :cup-of-tea))
(println "after inset")
(println (<!! tea-channel))

(println (>!! tea-channel :cup-of-tea-2))
(println (>!! tea-channel :cup-of-tea-3))
(println (>!! tea-channel :cup-of-tea-4))
(println (close! tea-channel))
(jin/titleBorder "closed")
(println (>!! tea-channel :cup-of-tea-5))
(println (<!! tea-channel))
(println (<!! tea-channel))
(println (<!! tea-channel))
(println (<!! tea-channel))

(jin/border)
(let [tea-channel-async (chan)]
  (go (>! tea-channel-async :cup-of-tea-1))
  (go (println "Thanks !!! " (<! tea-channel-async))))

(jin/border)
(def tea-channel3 (chan 10))
(go-loop []
  (println "Thanks for the" (<! tea-channel3))
  (recur))

(>!! tea-channel3 :hot-cup-of-tea)
(>!! tea-channel3 :tea-with-sugar)

