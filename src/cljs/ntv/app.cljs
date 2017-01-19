(ns ntv.app
  (:require [cljs.nodejs :as nodejs]
            [cljs.core.async :refer [chan >! alts!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(nodejs/enable-util-print!)

(def current-value (atom 1))

(defn factorial [max]
  (reduce (fn [acc i]
            (let [a (* acc i)]
              (reset! current-value a)
              (println "current value:" @current-value)
              a))
          (range 1 (+ max 1))))

(defn -main [& args]
  (let [n 10
        chans (repeatedly n chan)]

    (println "Running factorial" n "in" n "goroutines...")

    (go (let [[v c] (alts! chans)]
          (println "got" v "from" (.toString c))))

    (doseq [c chans]
      (go (>! c (factorial n))))))

(set! *main-cli-fn* -main)
