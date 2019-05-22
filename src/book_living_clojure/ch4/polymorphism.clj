(ns book-living-clojure.ch4.polymorphism
  (:require [book-living-clojure.core :as jin]))

(defn who-are-you [input]
  (cond
    (= java.lang.String (class input)) "String - Who are you?"
    (= clojure.lang.Keyword (class input)) "Keyword - Who are you?"
    (= java.lang.Long (class input)) "Number - Who are you?"))

(println (who-are-you :alice))
(println (who-are-you "alice"))
(println (who-are-you 123))
(println (who-are-you nil))

(jin/titleBorder "defmulti")

(defmulti who-are-you2 class)

(defmethod who-are-you2 java.lang.String [input]
  (str "String - Who are you?" input))

(defmethod who-are-you2 clojure.lang.Keyword [input]
  (str "Keyword - Who are you?" input))

(defmethod who-are-you2 java.lang.Long [input]
  (str "Number - Who are you?" input))

(defmethod who-are-you2 :default [input]
  (str "I don't know - who are you? " input))

(println (who-are-you2 :alice))
(println (who-are-you2 "alice"))
(println (who-are-you2 123))
(println (who-are-you2 true))

(jin/border)

(println ((fn [height] (if (< height 3) :grow :shrink)) 6))
(println ((#(if (< 1 3) :grow :shrink))))

;(defmulti eat-mushroom (fn [height]
;                         (if (< height 3)
;                           :grow
;                           :shrink)))
(defmulti eat-mushroom (#(if (< % 3)
                           :grow
                           :shrink)))

(defmethod eat-mushroom :grow [_] "Eat the right side to grow.")
(defmethod eat-mushroom :shrink [_] "Eat the left side to grow.")

(println (eat-mushroom 1))
(println (eat-mushroom 4))