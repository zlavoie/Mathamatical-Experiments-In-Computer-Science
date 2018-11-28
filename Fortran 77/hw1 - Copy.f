       !Zoe Lavoie
       !FORTRAN Assignment 1
       
       !Program #1
       
       program Asg1
       logical l1 !declare boolean
       integer num !declare integer
       real pie !declare real number
       character c1*14 !initialize character string to 14 spaces
       character*8 names(3) !initialize array to have 3 elements
                             !and have 8 spaces in the element
       !Specify All Variables
        names(1)='Bob'
        names(2)='Becky  '
        names(3)=' Ben'
       c1='slartibartfast'
       num = 42
       l1 = .FALSE.
       pie = 3.1415926
       !Print out all variables:
       write (*,*)'Integer: ',num
       write (*,*)'Boolean:', l1
       write (*,*)'Real Number:',pie
       write (*,*)'String:',c1
       write (*,*)'Name Array:',names
       write (*,*) '  '
       pause
       write (*,*)' '
       CALL coca_cola()
       write (*,*) ' '
       pause
       write (*,*) ' '
       CALL exponential()
       pause
       !coca_cola
       !Program #2
       
       end
       subroutine coca_cola()
       real NumCans !Explicit Declaration
       write (*,*)'This program computes the number of Coca-Cola'
       write (*,*)'present in a building given the height of the'
       write (*,*) 'building in stories'
       write (*,*)   ' '
       write (*,*) 'Please input the height of the building in stories:'
       read (*,*) Iheight !Implicit Declaration
                         !Variables and arrays that starts with the letters I,J,K,L,M,N are automatically taken as type Integer
       NumCans = Iheight*20 !so if there are 20 cans of coca-cola in every vending machine
                           !assuming that there is a vending machine on every floor
       real=NumCans !type coercion from integer to real
       write (*,*) 'The number of Coca-Cola cans is:',NumCans
       end
       
       subroutine exponential()
       integer a,n,result,count      !Declare variables
       write (*,*) 'This program computes the value of a^n'
       write(*,*) 'Enter a base number (a): '
       read (*,*) a    !Read in base
       write(*,*) 'Enter an exponent to raise the base to (n): '
       read (*,*) n   !Read in exponent
       
       result=1;
       do count=1,n  !DO loop that does that exponent calculation
       result=result*a
       continue
       enddo          !End Do loop
       
       write (*,*) 'The final result is:',result  !Final Result
       end
