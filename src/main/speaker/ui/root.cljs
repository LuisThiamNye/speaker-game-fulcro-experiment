(ns speaker.ui.root
  (:require
   [com.fulcrologic.fulcro.components :as comp :refer [defsc]]
   [com.fulcrologic.fulcro-native.alpha.components :as c :refer [ui-text ui-view]]
   [com.fulcrologic.fulcro.routing.dynamic-routing :as dr :refer [defrouter]]
   [speaker.ui.base-comps :as b]))


(defsc Main [this {:keys [label] :as props}]
  {:query         [:label]
   :initial-state {:label "Main"}
   :route-segment ["main"]
   :ident         (fn [] [:component/id :main])}
  (b/ui-container {}
                  (ui-text {} "hi")))

(defrouter RootRouter [_ _]
  {:router-targets [Main]})

(def ui-root-router (comp/factory RootRouter))

(defsc Root [this {:root/keys [router]}]
  {:query             [{:root/router (comp/get-query RootRouter)}]
   :componentDidMount (fn [this]
                        (dr/change-route this ["main"]))
   :initial-state     {:root/router {}}}
  (ui-root-router router))
