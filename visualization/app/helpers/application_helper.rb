module ApplicationHelper

  def icon(icon)
    raw "<span class='fs1' aria-hidden='true' data-icon='#{icon}'></span>"
  end

end
