import os
import subprocess
import sys

def install_virtualenv():
    """Ensure virtualenv is installed."""
    try:
        subprocess.check_call([sys.executable, "-m", "pip", "install", "--user", "virtualenv"])
    except Exception as e:
        print("Error installing virtualenv:", e)
        sys.exit(1)

def create_venv(venv_dir):
    """Create a virtual environment."""
    if not os.path.exists(venv_dir):
        os.makedirs(venv_dir, exist_ok=True)
        subprocess.check_call([sys.executable, "-m", "virtualenv", venv_dir])

def install_requirements(venv_dir):
    """Install requirements into the virtual environment."""
    pip_path = os.path.join(venv_dir, "bin", "pip") if os.name != "nt" else os.path.join(venv_dir, "Scripts", "pip.exe")
    subprocess.check_call([pip_path, "install", "-r", "requirements.txt"])

def main():
    venv_dir = os.path.join(os.getcwd(), "venv")
    print(f"Setting up Python environment in {venv_dir}...")

    # Step 1: Ensure virtualenv is available
    install_virtualenv()

    # Step 2: Create the virtual environment
    create_venv(venv_dir)

    # Step 3: Install dependencies
    install_requirements(venv_dir)

    print("\nSetup complete! Activate the environment using:")
    print(f"source {venv_dir}/bin/activate" if os.name != "nt" else f"{venv_dir}\\Scripts\\activate")

if __name__ == "__main__":
    main()