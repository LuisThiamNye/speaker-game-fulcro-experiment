(ns speaker.client
  (:require
   [com.fulcrologic.fulcro.application :as app]
   [com.fulcrologic.fulcro-native.expo-application :as expo]
   [speaker.application :refer [SPA]]
   [speaker.ui.root :as root]))


(defn ^:export start
  {:dev/after-load true}
  []
  (js/console.log "re-mounting...")
  ;; re-mounting will cause forced UI refresh, update internals, etc.
  (app/mount! @SPA root/Root :no-dom-element-here)
  ;; As of Fulcro 3.3.0, this addition will help with stale queries when using dynamic routing:
  ;; (comp/refresh-dynamic-queries! app)
  )

(defn ^:export init
  []
  (reset! SPA (expo/fulcro-app {}))
  (start)
  (js/console.log "Loaded"))
