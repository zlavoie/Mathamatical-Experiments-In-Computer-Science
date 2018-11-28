                program hw3
                implicit none

                call makeLittle()
                call little2big()
                call big2little()
                END

                SUBROUTINE little2big()
                integer n, i
                character bytes(4)
                integer perm(4)
                equivalence (i, bytes)

                n=1
                perm(n)=4
                perm(n+1)=3
                perm(n+2)=2
                perm(n+3)=1
                OPEN( 8, FILE='little.bin', FORM='UNFORMATTED')
                OPEN( 10, FILE='big.bin', FORM='UNFORMATTED')
                do while (n .NE. 4)
                        read(8) i
                        bytes= bytes(perm)
                        write(10) i
                        n=n+1
                end do
                close(8)
                close(10)
                END

                SUBROUTINE big2little()
                integer i, n
                character bytes(4)
                integer perm(4)
                equivalence (i, bytes)
                n=1
                perm(n)=4
                perm(n+1)=3
                perm(n+2)=2
                perm(n+3)=1
                OPEN( 8, FILE='little2.bin', FORM='UNFORMATTED')
                OPEN( 10, FILE='big.bin', FORM='UNFORMATTED')
                do while (n .NE. 4)
                        read(10) i
                        bytes = bytes(perm)
                        write(8) i
                        n=n+1
                end do
                close(8)
                close(10)
                END

                INTEGER A,B,C

                A=42
                B=4200
                C=42000

                OPEN(8,FILE='little.bin',STATUS='NEW',FORM='UNFORMATTED',action='WRITE')
                WRITE(8)A,B,C
                CLOSE(8,STATUS='KEEP')
                STOP 'End of program'
                END


