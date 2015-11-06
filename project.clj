(defproject anki-t "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [ring/ring-json "0.4.0"]
                 [http-kit "2.1.18"]
                 [cheshire "5.5.0"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler anki-t.handler/app
         :init anki-t.handler/init
         :destroy anki-t.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
