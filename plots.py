import glob
import pandas as pd
import matplotlib.pyplot as plt
import os

def process_csv_files():
    csv_files = glob.glob("*.csv")
    for file in csv_files:
        if os.path.exists(file):
            df = pd.read_csv(file, header=None, names=["x", "y"])
            plt.figure(figsize=(10, 5))
            plt.plot(df["x"], df["y"], label=file.replace(".csv", ""))
            plt.axhline(0, color="gray", linewidth=0.5)
            plt.axvline(0, color="gray", linewidth=0.5)
            plt.legend()
            plt.title(f"График функции: {file.replace('.csv', '')}")
            plt.xlabel("x")
            plt.ylabel("f(x)")
            plt.grid(True)
            plt.tight_layout()
            plt.savefig(f"{file.replace('.csv', '')}.png")  # сохранить как PNG
            plt.show()
        else:
            print(f"Файл {file} не найден.")
if __name__ == "__main__":
    process_csv_files()