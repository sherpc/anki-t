(ns anki-t.anki
  (:require [org.httpkit.client :as http]))


(defn method-url [path] (str "https://ankiweb.net" path))
(def login-url (method-url "/account/login"))

(def default-options {:user-agent "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36"
                      :headers {"Accept" "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
                                "Accept-Language" "en-US,en;q=0.8,ru;q=0.6,bg;q=0.4"}
                      :insecure? true})

(defn get-form-params
  [login password]
  {:form-params {:submitted 1 :login login :password password}})

(defn login
  [login password]
  (let [options (get-form-params login password)]
    (http/post login-url (merge default-options options))))

;; Doesn't works for http-kit
;;(System/setProperty "http.proxyHost" "localhost")
;;(System/setProperty "http.proxyPort" "8888")

;;(def p (login "aleksandrsher@gmail.com" "12as12"))

;;(-> @p :body)

