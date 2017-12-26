import smtplib
import sys

if len(sys.argv) < 2 and (sys.argv.__contains__('-h') or sys.argv.__contains__('help')) or len(sys.argv) < 3 and \
        not (sys.argv.__contains__('-h') or sys.argv.__contains__('help')):
    print("\nMailSploit: Missing Arguments!\n\nUse \"python3 mailsploit.py -h\" for help")
    exit(1)

if sys.argv.__contains__('help') or sys.argv.__contains__('-h'):
    print("\n\nWelcome to MailSploit!\n\n" 
           "The only exploit tool that will get you your friends email "
          "passwords within seconds!\n\n"
          "\nExamples:\n\npython3 mailsploit.py your@mail.com friend@mail.com")
    exit(2)

gmail_user = 'notciagent1234@gmail.com'

sent_from = gmail_user  
to = sys.argv
subject = 'You\'ve Been Hacked!!!\n\n\n'
body = 'Hello citizen, this email could be sent from a real hacker ' \
       'if not for our great country cyber security agents,\n' \
       'Lets take a moment to appreciate those talented and highly skilled heros,\n' \
       'Without them our privacy will be in a serious danger!' \
        '\nAND REMEMBER: NEVER EXCUTE AN EXPLOIT WITHOUT READING THE CODE FIRST!\n'\
       '\n\n\nBe Safe, Your precious government'

email_text = """\n  
From: %s \n 
To: %s  \n
Subject: %s \n

%s
""" % (sent_from, ", ".join(to), subject, body)

try:  
    server = smtplib.SMTP_SSL('smtp.gmail.com', 465)
    server.ehlo()
    server.login(gmail_user, 'HARDTOGUESSPASSWORD')
    server.sendmail(sent_from, to, email_text)
    server.close()

    print('The Exploit Email Was Sent!')
except:  
    print('Something went wrong...')