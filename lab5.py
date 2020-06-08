from os import path
import re

NZK =9227
I = NZK % 17
print("Уткін Владислав")
print("Номер залікової книжки:", NZK)
print("Варіант:",I)

word_counter = 1
symbol_counter = 1
sentence_counter = 1




class Main:
    text = ''
    def __init__(self, text):
        self.sentences = list()
        split_regex = re.compile(r'[.|!|?|…|\v]|\n')
        sentences = filter(lambda t: t, [t.strip() for t in split_regex.split(text)])
        for s in sentences:
            self.sentences.append(s)
            Sentences(self.sentences[-1])
        print('речення тексту: ', self.sentences)


class Sentences:
    def __init__(self, sentences):
        global sentence_counter
        self.words = list()
        split_regex = re.compile(r'[' '| : | ( | )| , |-]')
        words = filter(lambda t: t, [t.strip() for t in split_regex.split(sentences)])
        for s in words:
            self.words.append(s)
            Words(self.words[-1])
        print('Речення ', sentence_counter, self.words)
        sentence_counter += 1


class Words:
    palindrome = ''
    palindromes = list()

    def __init__(self, words):
        global sentence_counter, word_counter
        self.chars = list()
        for q in words:
            Main.text = Main.text + q
            self.chars.append(q)
            Symbol(self.chars[-1])
        print('Слово ', word_counter, 'Речення ', sentence_counter, self.chars)
        word_counter += 1
        self.Palindrome()

    def Palindrome(self):
        s = Main.text.lower()
        self.chars = list(s)
        for i in range(1, len(s) - 1):
            if min(i, len(s) - i) * 2 + 1 <= len(self.palindrome):
                continue
            for odd in [1, 0]:
                if s[i + odd] != s[i - 1]:
                    continue
                halfSize = len(path.commonprefix([s[i + odd:], s[:i][::-1]]))
                if 2 * halfSize + odd > len(self.palindrome):
                    self.longest = s[i - halfSize:i + halfSize + odd]
                    break
        try:
            self.palindromes.append(self.longest)
        except AttributeError:
            pass


class Symbol:
    def __init__(self, chars):
        global sentence_counter, word_counter, symbol_counter
        self.chars2 = list()
        for z in chars:
            self.chars2.append(z)
        print('Символ ', symbol_counter, 'Слова ', word_counter, 'Речення ', sentence_counter, self.chars2)
        symbol_counter += 1




Text = Main(input('Введення тексту: '))
print("Найдовший паліндром: ", Words.palindromes[-1])
