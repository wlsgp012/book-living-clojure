(ns book-living-clojure.ch11.transducers
  (:require [clojure.core.async :as async]
            [book-living-clojure.core :as jin]))


(def flowers ["White carnation"
              "yellow daffodil"
              "yellow rose"
              "red rose"
              "white rose"
              "purple lily"
              "pink carnation"])

(defn paint-it-red [s]
  (str "red "
       (last (clojure.string/split s #"\s"))))

(println (map paint-it-red flowers))

(defn is-a-rose? [s]
  (= "rose" (last (clojure.string/split s #"\s"))))

(println (filter is-a-rose? flowers))

(def fix-for-the-queen-xform
  (comp
    (map paint-it-red)
    (filter is-a-rose?)))

(println (into [] fix-for-the-queen-xform flowers))
(println (take 1 (sequence fix-for-the-queen-xform flowers)))
(println (transduce fix-for-the-queen-xform (completing #(str %1 %2 ":")) "" flowers))

(jin/titleBorder "async")

(def flower-chan (async/chan 1 fix-for-the-queen-xform))

(def result-chan (async/reduce (completing  #(str %1 %2 ":")) "" flower-chan))

(async/onto-chan flower-chan flowers)

(def flowers-for-the-queen (async/<!! result-chan))

(println flowers-for-the-queen)