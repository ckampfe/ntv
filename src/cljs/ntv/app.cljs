(ns ntv.app
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(defn -main [& args]
  (println "Hello, World!"))

(set! *main-cli-fn* -main)
