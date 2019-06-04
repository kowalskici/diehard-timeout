(ns die-hard-timeout.core
  (:require [diehard.core :as dh]))

(def thread-sleep-time 8000)

(defn barely-a-timeout []
  (let [start (System/currentTimeMillis)]
    (dh/with-retry {:delay-ms 500
                    :max-duration-ms 3000
                    :retry-if (fn [result e] (nil? result))
                    :on-failed-attempt (fn [result e]
                                         (do (println "Retrying: result: " result " e: " e)))
                    :on-failure (fn [result e]
                                  (do (println "Failure end: result: " result " e: " e)))
                    :on-abort (fn [result e] (println "Aborted"))
                    :on-complete (fn [result] (println "Success"))}

                   (Thread/sleep thread-sleep-time)
                   (let [end (System/currentTimeMillis)]
                     (println "Time spent (in ms): " (- end start))))))

