(ns anki-t.telegram
  (:require [org.httpkit.client :as http]
            [cheshire.core :refer [generate-string]]))

(def api-key "178118172:AAGB4v-L-GhVJ8No-nGHO7ccC35c490YK6g")


(def sher-id "79034002")

(def send-message-url (str "https://api.telegram.org/bot" api-key "/sendMessage"))

(defn message-params
  [chat-id text]
  {:chat_id chat-id
   :text text})

(defn add-custom-keyboard
  [message keyboard]
  (assoc message :reply_markup keyboard))

(defn create-keyboard
  [layout]
  (generate-string
    {:keyboard layout
     :one_time_keyboard true
     :resize_keyboard true}))

(def simple-kb (create-keyboard [["1" "2"] ["3" "4"]]))

(defn send-message
  "Send message to Telegram user. Keyboard is custom keyboard layout, array of array of strings. May be nil."
  [chat-id text keyboard]
  (let [basic (message-params chat-id text)
        kb (if keyboard (add-custom-keyboard basic (create-keyboard keyboard)) basic)
        ;;_ (println kb)
        params {:query-params kb}]
    (http/get send-message-url params)))

;;(def p (send-message sher-id "привет" [["не помню"] ["good"] ["awesome!"]]))
;;(-> @p :body)

