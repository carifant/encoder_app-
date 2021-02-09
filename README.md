This program can encryption and decryption text or text files. 
You can manage it by command line.
The program parse next arguments: -in, -out, -alg, -mode, -key and -data. 
The mode argument should determine the program’s mode 
(enc for encryption, dec for decryption).
 The key argument is an integer key to modify the message, 
the data argument is a text or ciphertext to encrypt or decrypt.
The algorithm argument is a choose mode of encryption (shift or unicode).
The first one encryption only letters.

All the arguments are guaranteed to be passed to the program. 
If for some reason it turns out to be wrong:

    If there is no -mode, the program work in enc mode.
    If there is no -key, the program consider that key = 0.
    If there is no -alg, the program consider that alg = shift.
    If there is no -data, the program assume that the data is an empty string.
Program read data from -data or from a file written in the 
-in argument. That's why you can't have both -data and -in arguments
 simultaneously, only one of them.
  
    If there is no -out argument, the program print data to the standard output.
    If there are both -data and -in arguments, your program prefer -data over -in.
