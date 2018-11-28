      program ASG_0
      implicit none
      c
      call poem()
      end

      subroutine poem()
      implicit none
      c
      l1 = "You have to learn to pace yourself... FORTRAN"
      l2 ="You''re just like everybody else...FORTRAN"
      l3="You''ve only had to write C++ so far"
      l4="But you will come to the day"
      l5="When the only thing that counts"
      l6="Are megaflops on a Cray"
      l7="And you''ll have to deal with... FORTRAN"

      write (*,*) l1
      write (*,*) l2
      write (*,*) l3
      write (*,*) l4
      write (*,*) line5
      write (*,*) line6
      write (*,*) line6
      c
      end
