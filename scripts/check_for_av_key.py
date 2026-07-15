import re
from pathlib import Path

config_path = Path.home() / ".config/niri/config.kdl"
if not config_path.exists():
    print("Niri config not found!")
    exit()

content = config_path.read_text()

# Find the binds { ... } section block
binds_match = re.search(r"binds\s*\{(.*?)\n\}", content, re.DOTALL)
if not binds_match:
    print("No binds section found.")
    exit()

binds_block = binds_match.group(1)

print("=== OCCUPIED NIRI KEYBINDS ===")
# Match lines that look like keybind definitions (ignoring comments)
for line in binds_block.splitlines():
    line = line.strip()
    if line.startswith("//") or not line:
        continue
    # Extract strings like Mod+Space, Mod+Shift+T, etc.
    match = re.match(r"^([a-zA-Z0-9\+\-]+)", line)
    if match:
        keybind = match.group(1)
        if keybind not in ["Mod", "Shift", "Alt"]:  # Filter out incomplete fragments
            print(f" 󰘳  {keybind}")
