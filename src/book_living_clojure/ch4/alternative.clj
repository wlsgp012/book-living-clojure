(ns book-living-clojure.ch4.alternative)

(defn bite-right-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow bigger"
    "The bite tastes bad"))

(defn bite-left-side [mushroom]
  (if (= (:type mushroom) "wonderland")
    "The bite makes you grow smaller"
    "The bite tastes bad too"))

(println (bite-right-side {:type "wonderland"}))
(println (bite-left-side {:type "wonderland"}))

(println (bite-right-side {:type "regular"}))
(println (bite-left-side {:type "regular"}))