(ns book-living-clojure.ch4.protocol
  (:require [book-living-clojure.core :as jin]))

(jin/border)
(defprotocol BigMushroom
  (eat-mushroom [this]))

(extend-protocol BigMushroom
  java.lang.String
  (eat-mushroom [this]
    (str (.toUpperCase this) " mmm tasty!"))

  clojure.lang.Keyword
  (eat-mushroom [this]
    (case this
      :grow "Eat the right side!"
      :shrink "Eat the left side!"))

  java.lang.Long
  (eat-mushroom [this]
    (if (< this 3)
      "Eat the right side to grow"
      "Eat the left side to shrink")))

(println (eat-mushroom "Big Mushroom"))
(println (eat-mushroom :grow))
(println (eat-mushroom :shrink))
(println (eat-mushroom 1))

(jin/border)

(defrecord Mushroom [color height])

(println Mushroom)
(def regular-mushroom (Mushroom. "white and blue polka dots" "2 inches"))

(println regular-mushroom)
(println (class regular-mushroom))
(println (.-color regular-mushroom))
(println (.-height regular-mushroom))

(jin/border)

(defprotocol Edible
  (bite-right-side [this])
  (bite-left-side [this]))

(defrecord WonderlandMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite makes you grow bigger"))
  (bite-left-side [this]
    (str "The " color " bite makes you grow smaller")))

(defrecord RegularMushroom [color height]
  Edible
  (bite-right-side [this]
    (str "The " color " bite tastes bad"))
  (bite-left-side [this]
    (str "The " color " bite tastes bad too")))

(def alice-mushroom (WonderlandMushroom. "blue dots" "3 inches"))
(def reg-mushroom (RegularMushroom. "brown" "1 inches"))

(println (bite-right-side alice-mushroom))
(println (bite-left-side alice-mushroom))

(println (bite-right-side reg-mushroom))
(println (bite-left-side reg-mushroom))

(jin/titleBorder "deftype")

(deftype WonderlandMushroom2 []
  Edible
  (bite-right-side [this]
    (str "The bite tastes bad"))
  (bite-left-side [this]
    (str "The bite tastes bad too")))

(deftype RegularMushroom2 []
  Edible
  (bite-right-side [this]
    (str "The bite tastes bad"))
  (bite-left-side [this]
    (str "The bite tastes bad too")))

(def alice-mushroom2 (WonderlandMushroom2.))
(def reg-mushroom2 (RegularMushroom2.))

(println (bite-right-side alice-mushroom2))
(println (bite-left-side alice-mushroom2))

(println (bite-right-side reg-mushroom2))
(println (bite-left-side reg-mushroom2))











