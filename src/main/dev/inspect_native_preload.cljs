(ns dev.inspect-native-preload
  (:require
   [com.fulcrologic.fulcro.inspect.inspect-client :as inspect]
   [com.fulcrologic.fulcro.inspect.inspect-ws :as inspect-ws]))

(when-not @inspect/started?*
  (reset! inspect/started?* true)
  ;; Workaround for https://github.com/ptaoussanis/sente/issues/361
  (inspect-ws/start-ws-messaging! {:channel-type :ajax}))
