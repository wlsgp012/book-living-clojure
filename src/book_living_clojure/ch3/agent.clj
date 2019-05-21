(ns book-living-clojure.ch3.agent)

(def who-agent (agent :caterpillar))

(defn change [state]
  (case state
    :caterpillar :chrysalis
    :chrysalis :butterfly
    :butterfly))

(defn change-error [state]
  (throw (Exception. "Boom!")))

(send who-agent change-error)
(println @who-agent)

(println (agent-error who-agent))
(restart-agent who-agent :caterpillar)

; 동작 안함!!
;(set-error-mode! who-agent :continue)
;(defn err-handler-fn [a ex]
;  (println "error " ex "value is " @a))
;(set-error-handler! who-agent err-handler-fn)

(send who-agent change)
(println @who-agent)

(send-off who-agent change)
(println @who-agent)
