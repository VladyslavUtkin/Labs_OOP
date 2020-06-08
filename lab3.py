from os import path

NZK =9227
I = NZK % 17
print("Уткін Владислав")
print("Номер залікової книжки:", NZK)
print("Варіант:",I)


class Lab3:
    def __init__(self, string):
        self.string = string
        self.polindrome = ''

    def lab3(self):
        j = self.string
        for i in range(1, len(j) - 1):
            if min(i, len(j) - i) * 2 + 1 <= len(self.polindrome):
                continue
            for odd in [1, 0]:
                if j[i + odd] != j[i - 1]:
                    continue
                halfSize = len(path.commonprefix([j[i + odd:], j[:i][::-1]]))
                if 2 * halfSize + odd > len(self.polindrome):
                    longest = j[i - halfSize:i + halfSize + odd]
                    break
        return longest

    def start(self):
        print(self.lab3())

Text = Lab3(input('Введення тексту: '))
Text.start()