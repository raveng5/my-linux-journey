#!/bin/bash
# this script needs to be here: ~/.local/bin/captive-portal-observer.sh

# האזנה לאירועי NetworkManager ברמת המשתמש
nmcli monitor | while read -r line; do
    # בדיקה האם מצב החיבור השתנה ל-portal
    CONNECTIVITY=$(nmcli networking connectivity check)

    if [ "$CONNECTIVITY" = "portal" ]; then
        # שליחת התראה ל-SwayNC עם כפתור הרצה
        ACTION=$(notify-send "🌐 Public Wi-Fi Detected" \
            "Click to open the login page" \
            --icon=network-wireless-hotspot \
            --action="open=Open Login Page" \
            --urgency=critical)

        if [ "$ACTION" = "open" ]; then
            # פתיחת דף הנחיתה בדפדפן המבודד Epiphany
            epiphany "http://neverssl.com" &
        fi
    fi
done
