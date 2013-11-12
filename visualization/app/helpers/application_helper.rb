module ApplicationHelper

  def icon(icon)
    raw "<span class='fs1' aria-hidden='true' data-icon='#{icon}'></span>"
  end

  def menu_items
    [
      [ t("Dashboard"), "&#xe0a2;", root_url ],
      [ t("Settings"), "&#xe090;", settings_url ]
    ]
  end

end
