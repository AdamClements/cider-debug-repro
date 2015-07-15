(ns repro.core
  (:require [org.httpkit.server :refer [run-server]]))

(defn get-body-response []
  (let [a "Hello "
        b "World"]
    (str a b "!")))

(defn handler [req]
  (let [bod (get-body-response)]
   {:status 200
    :headers {}
    :body bod}))

(defn serve []
  (run-server #'handler {:port 3000}))
