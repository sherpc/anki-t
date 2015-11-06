(ns anki-t.routes.home
  (:require [compojure.core :refer :all]
            [clojure.pprint :refer [pprint]]
            [anki-t.views.layout :as layout]))

(defn from-telegram [data]
  (pprint data)
  {:status 200})

(defn home []
  (layout/common [:h1 "Hello!"]))

(def anki-t-key "")

(defroutes home-routes
  (GET "/" [] (home))
  (GET "/123" [] (home))
  (POST "/VIWjrMex19N1Mm02YjsG" {data :body} (from-telegram data)))
