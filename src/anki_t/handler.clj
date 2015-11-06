(ns anki-t.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.middleware.json :refer [wrap-json-body]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [anki-t.routes.home :refer [home-routes]]))

(defn init []
  (println "anki-t is starting"))

(defn destroy []
  (println "anki-t is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)
      (wrap-json-body {:keywords? true :bigdecimals? true})))
