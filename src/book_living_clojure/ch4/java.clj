(ns book-living-clojure.ch4.java
  (:require [book-living-clojure.core :as jin])
  (:import (java.net InetAddress)))

;(require '[book-living-clojure.core :as jin])

(println (class "caterpillar"))

(println (. "caterpillar" toUpperCase))
(println (.toUpperCase "caterpillar"))

(println (.indexOf "caterpillar" "pillar"))

(println (new String "Hi!!"))
(println (String. "Hi!!"))

(jin/border)

(def local (InetAddress/getByName "localhost"))
(println (.toString local))

(jin/border)
(println (java.net.InetAddress/getByName "localhost"))

(jin/titleBorder "doto usage")

(def sb (doto (StringBuffer. "who ")
          (.append "are ")
          (.append "you?")))
(println (.toString sb))

(def sb2 (.append (.append (StringBuffer. "Who ") "are ") "you?"))
(println (.toString sb2))

(jin/titleBorder "uuid")
(import 'java.util.UUID)
(println (UUID/randomUUID))
