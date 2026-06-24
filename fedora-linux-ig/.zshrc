
# Load zsh-syntax-highlighting
source /usr/share/zsh-syntax-highlighting/zsh-syntax-highlighting.zsh

# Load zsh-autosuggestions
source /usr/share/zsh-autosuggestions/zsh-autosuggestions.zsh

# Initialize Starship Prompt
eval "$(starship init zsh)"
fastfetch
alias zed="/home/ig/.local/zed.app/bin/zed"

# Force upload the entire dotfiles directory exactly as it is right now
gitup() {
    # Check if we are in the dotfiles directory, if not, jump there
    cd /home/ig/dotfiles || return

    echo "🧼 Preparing clean slate..."
    git add -A

    echo "📝 Creating fresh snapshot..."
    git commit -m "Full upload: $(date '+%Y-%m-%d %H:%M:%S')" --allow-empty

    echo "🚀 Force pushing the entire directory..."
    git push origin $(git branch --show-current) --force

    echo "✅ Done! Your GitHub matches your local folder 100%."
}
