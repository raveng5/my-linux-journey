
# Load zsh-syntax-highlighting
source /usr/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh

# Load zsh-autosuggestions
source /usr/share/zsh-autosuggestions/zsh-autosuggestions.zsh

# Initialize Starship Prompt
eval "$(starship init zsh)"

# start with fastfetch
fastfetch

# some aliases
alias zed="/home/ig/.local/zed.app/bin/zed"
alias rezsh="source ~/.zshrc"

# Force upload the entire dotfiles directory exactly as it is right now
gitup() {
    # Check if we are in the dotfiles directory, if not, jump there
    cd /home/ig/dotfiles || return

    echo "Preparing"
    git add -A

    echo "Creating fresh snapshot"
    git commit -m "Full upload: $(date '+%Y-%m-%d %H:%M:%S')" --allow-empty

    echo "Force pushing the entire directory..."
    git push origin $(git branch --show-current) --force

    echo "done"
}

# an shortcut for coping and pasting config files to github
gitcopy() {
    echo "starting"
    rm -r /home/ig/dotfiles/fedora-linux-ig/myconfigs
    mkdir /home/ig/dotfiles/fedora-linux-ig/myconfigs
    cp -r ~/.config/{fuzzel,fastfetch,niri,waybar,starship.toml,kitty} /home/ig/dotfiles/fedora-linux-ig/myconfigs/
    echo "and..."
    rm /home/ig/dotfiles/fedora-linux-ig/.zshrc
    cp /home/ig/.zshrc /home/ig/dotfiles/fedora-linux-ig/.zshrc
    echo "done"

}

#change wallpaper
wallpaper() {
    if [ -z "$1" ]; then
        echo "choose a wallpaper number. example: wallpaper 1"
        return 1
    fi


    sed -i "273s/wallpaper[0-9]\+\.jpg/wallpaper${1}.jpg/" ~/.config/niri/config.kdl

    echo "changed wallpaper to wallpaper${1}"
}
