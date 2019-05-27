(ns book-living-clojure.ch8.make-macro)

(defn hi-queen [phrase]
  (str phrase ", so please your Majesty."))

(defn alice-hi-queen []
  (hi-queen "My name is Alice"))

(println (alice-hi-queen))

(defn march-hare-hi-queen []
  (hi-queen "I'm the March Hare"))

(println (march-hare-hi-queen))

(defn white-rabbit-hi-queen []
  (hi-queen "I'm the White Rabbit"))

(println (white-rabbit-hi-queen))

(defn mad-hatter-hi-queen []
  (hi-queen "I'm the Mad Hatter"))

(println (mad-hatter-hi-queen))

(defmacro def-hi-queen [name phrase]
  (list 'defn (symbol name) [] (list 'hi-queen phrase)))

(println (macroexpand-1 '(def-hi-queen alice-hi-queen "My name is Alice")))

(def-hi-queen alice-hi-queen-by-macro "My name is Alice")

(println (alice-hi-queen-by-macro))